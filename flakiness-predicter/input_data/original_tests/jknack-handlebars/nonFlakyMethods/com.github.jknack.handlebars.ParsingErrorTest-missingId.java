@Test(expected=HandlebarsException.class) public void missingId() throws IOException {
  parse("{{is");
}
