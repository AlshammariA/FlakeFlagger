@Test(expected=HandlebarsException.class) public void ampvarDelim() throws IOException {
  parse("{{=** **=}}**&tvar");
}
