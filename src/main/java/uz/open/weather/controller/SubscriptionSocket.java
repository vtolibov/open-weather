package uz.open.weather.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import uz.open.weather.dto.subscription.Subscription;
import uz.open.weather.dto.subscription.SubscriptionsRequestDto;
import uz.open.weather.service.SubscriptionService;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@ClientEndpoint
@ServerEndpoint("/get_subscription_list")
@RequiredArgsConstructor
public class SubscriptionSocket {

    private final SubscriptionService<Subscription, Long> subscriptionService;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket connection opened: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        AtomicInteger subscriptionStatus = new AtomicInteger(0);
        SubscriptionsRequestDto subscriptionsRequest = null;
        try {
            subscriptionsRequest = new ObjectMapper().readValue(message, SubscriptionsRequestDto.class);
        } catch (JsonProcessingException jsonException) {
            session.getBasicRemote().sendText(jsonException.getMessage());
        }
        if (subscriptionsRequest != null) {
            subscriptionStatus.addAndGet(subscriptionsRequest.getSubscribe());
            while (subscriptionStatus.get() == 1) {
                subscriptionService.getSubscriptionList(subscriptionsRequest.getUserId())
                        .flatMap(subscription -> subscriptionService.getSubscriptionInfoFromLocation(subscription.getSubscriptionId()))
                        .flatMap(Mono::just)
                        .subscribe(json -> {
                            try {
                                session.getBasicRemote().sendText(json);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket connection closed: " + session.getId());
    }
}
