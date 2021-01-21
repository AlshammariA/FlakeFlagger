@Test public void genericTypeSafe() throws IOException {
  User user=new User("edgar");
  TypeSafeTemplate<User> userTemplate=compile("Hello {{name}}!").as();
  assertEquals("Hello edgar!",userTemplate.apply(user));
}
