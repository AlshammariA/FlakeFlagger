@Test(expected=HandlebarsException.class) public void level2() throws IOException {
  parse("deep");
}
