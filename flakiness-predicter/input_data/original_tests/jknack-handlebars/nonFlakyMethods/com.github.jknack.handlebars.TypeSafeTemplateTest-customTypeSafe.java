@Test public void customTypeSafe() throws IOException {
  User user=new User("Edgar");
  UserTemplate userTemplate=compile("{{name}} is {{age}} years old!").as(UserTemplate.class).setAge(32);
  assertEquals("Edgar is 32 years old!",userTemplate.apply(user));
}
