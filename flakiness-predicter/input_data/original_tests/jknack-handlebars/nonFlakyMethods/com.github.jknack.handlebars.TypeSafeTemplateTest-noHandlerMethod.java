@Test(expected=UnsupportedOperationException.class) public void noHandlerMethod() throws IOException {
  UserTemplate userTemplate=compile("{{role}}").as(UserTemplate.class);
  userTemplate.set(6);
}
