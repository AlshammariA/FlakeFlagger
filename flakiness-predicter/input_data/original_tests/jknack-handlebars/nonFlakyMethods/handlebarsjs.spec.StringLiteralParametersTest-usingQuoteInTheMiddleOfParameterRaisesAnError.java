@Test(expected=HandlebarsException.class) public void usingQuoteInTheMiddleOfParameterRaisesAnError() throws IOException {
  shouldCompileTo("Message: {{hello wo\"rld\"}}",$,null);
}
