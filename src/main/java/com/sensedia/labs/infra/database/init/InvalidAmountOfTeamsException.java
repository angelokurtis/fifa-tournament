package com.sensedia.labs.infra.database.init;

class InvalidAmountOfTeamsException extends RuntimeException {

  InvalidAmountOfTeamsException() {
    super("Must have at least 2 registered teams.");
  }
}
