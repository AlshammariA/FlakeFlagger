@Test(expected=HandlebarsException.class) public void correctPath() throws IOException {
  parse("inbox/inbox");
}
