@Test(expected=HandlebarsException.class) public void blockHelperMissingFail() throws IOException {
  shouldCompileTo("{{#missing x}}This is a mustache fallback{{/missing}}",new Object(),"must fail");
}
