@Test(expected=HandlebarsException.class) public void tvar() throws IOException {
  parse("{{{tvar");
}
