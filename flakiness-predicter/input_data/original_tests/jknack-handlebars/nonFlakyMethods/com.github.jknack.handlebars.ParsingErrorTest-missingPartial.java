@Test(expected=HandlebarsException.class) public void missingPartial() throws IOException {
  parse("default");
}
