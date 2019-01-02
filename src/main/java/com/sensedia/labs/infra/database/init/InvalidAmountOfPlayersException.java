package com.sensedia.labs.infra.database.init;

class InvalidAmountOfPlayersException extends RuntimeException {

  InvalidAmountOfPlayersException() {
    super("Must have at least 2 registered players.");
  }
}
