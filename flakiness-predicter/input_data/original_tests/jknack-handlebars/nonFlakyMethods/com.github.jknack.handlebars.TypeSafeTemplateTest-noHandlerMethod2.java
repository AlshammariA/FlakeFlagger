@Test(expected=UnsupportedOperationException.class) public void noHandlerMethod2() throws IOException {
  UserTemplate userTemplate=compile("{{role}}").as(UserTemplate.class);
  userTemplate.set();
}
