@Test(expected=HandlebarsException.class) public void tvarDelim() throws IOException {
  parse("{{=** **=}}**{tvar");
}
