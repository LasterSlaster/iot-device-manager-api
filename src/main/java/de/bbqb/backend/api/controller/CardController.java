package de.bbqb.backend.api.controller;

import de.bbqb.backend.api.model.entity.*;
import de.bbqb.backend.api.model.service.UserService;
import de.bbqb.backend.stripe.StripeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * REST Controller with endpoints to manage card resources
 *
 * @author Marius Degen
 */
@CrossOrigin(origins = "*") // CORS configuration to allow all for the endpoints in this controller
@RestController
public class CardController {

    private UserService userService;
    private StripeService stripeService;

    public CardController(UserService userService, StripeService stripeService) {
        super();
        this.userService = userService;
        this.stripeService = stripeService;
    }

    /**
     * Retrieve all cards for a specific user.
     *
     * @return The list of cards for this user
     */
    @GetMapping("/cards")
    public Mono<ResponseEntity<List<Card>>> getCards(@AuthenticationPrincipal Authentication sub) {
        return stripeService.readCards(sub.getName())
                .map(ResponseEntity::ok);
    }

    /**
     * Delete a specific card for a user
     *
     * @return The deleted card
     */
    @DeleteMapping("/cards/{id}")
    public Mono<ResponseEntity<Card>> deleteCard(@AuthenticationPrincipal Authentication sub, @PathVariable("id") String cardId) {
        return stripeService.deleteCard(cardId, sub.getName())
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.notFound().build());
    }

    /**
     * Create a SetupIntent to add a card as a payment method for a customer/user on stripe.
     *
     * @return A client secret to complete the SetupIntent
     */
    @PostMapping("/cards")
    public Mono<ResponseEntity<Card>> postCardSetup(@AuthenticationPrincipal Authentication sub) {
        return stripeService.createSetupCardIntent(sub.getName())
                .map(ResponseEntity::ok);
    }

}
