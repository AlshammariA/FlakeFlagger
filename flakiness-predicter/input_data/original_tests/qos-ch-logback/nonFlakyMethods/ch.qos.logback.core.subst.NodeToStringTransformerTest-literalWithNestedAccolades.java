@Test public void literalWithNestedAccolades() throws ScanException {
  checkInputEqualsOutput("%logger{35}");
  checkInputEqualsOutput("%a{35} %b{35} c");
  checkInputEqualsOutput("%replace(%msg){'\\d{14,16}', 'XXXX'}");
  checkInputEqualsOutput("TEST %d{HHmmssSSS} [%thread] %-5level %logger{36} - %msg%n");
}
