(function () {

    'use strict';
    angular.module('myApp.game')
        .factory('GameService', GameService);

    /* @ngInject */
    function GameService(Restangular) {
        var service = {
            checkSet: checkSet,
            containsSet: containsSet,
            giveCards: giveCards,
            isHighScore: isHighScore,
            keepHighScore: keepHighScore,
            shuffleDeck: shuffelDeck,


        	// createGame: createGame,
        	// drawThreeCards: drawThreeCards,
        	// getScore: getScore,
        	// incrementScore: incrementScore,
        	// isValidSet: isValidSet,
        	// setHighScore: setHighScore
        };
        return service;
        //----------------------------------------------------------------------------//

        function checkSet(cards) {
            return Restangular.all('check').post(cards).then(_cleanResponse);
        }

        function containsSet(board) {
            return Restangular.all('/containsSet').post(board).then(_cleanResponse);
        }

        function giveCards(numberOfCards, cardsInGame) {
            return Restangular.all('/cards/draw').post(numberOfCards, cardsInGame).then(_cleanResponse);
        }

        function isHighScore(highScore) {
            return Restangular.one('highscore/isHigh', highScore).get().then(_cleanResponse);
        }

        function keepHighScore() {
            return Restangular.one('highscore/set').put(highScore).then(_cleanResponse);
        }

        function shuffleDeck() {
            return Restangular.one('cards/createGame').get().then(_cleanResponse);
        }



        function createGame() {
        	return Restangular.all('cards/createGame').get().then(_cleanResponse);
        }
        
        function drawThreeCards(gameId) {
        	return Restangular.one('cards/draw', gameId).get().then(_cleanResponse);
        }
        
        function getScore(gameId) {
        	return Restangular.all('score/get', gameId).get().then(_cleanResponse);
        }
        
        function incrementScore(gameId) {
        	return Restangular.one('score/increment').put(gameId).then(_cleanResponse);
        }
        

        function isValidSet(cards) {
        	return Restangular.all('cards/check').post(cards).then(_cleanResponse);
        }
        
        function setHighScore(highScore) {
        	return Restangular.one('highscore/set').put(highScore).then(_cleanResponse);
        }

        function _boolean(response) {
            if (angular.isUndefined(response)) {
                return false;
            }
            return response;
        }

        function _cleanResponse(response) {
            return Restangular.stripRestangular(response);
        }
    }
}());
