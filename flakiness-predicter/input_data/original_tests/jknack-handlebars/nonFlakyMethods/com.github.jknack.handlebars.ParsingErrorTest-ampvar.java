@Test(expected=HandlebarsException.class) public void ampvar() throws IOException {
  parse("{{&tvar");
}
