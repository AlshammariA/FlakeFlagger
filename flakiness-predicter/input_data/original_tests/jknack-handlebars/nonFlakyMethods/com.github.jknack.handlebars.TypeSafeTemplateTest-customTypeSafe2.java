@Test public void customTypeSafe2() throws IOException {
  User user=new User("Edgar");
  UserTemplate userTemplate=compile("{{role}}").as(UserTemplate.class).setRole("Software Architect");
  assertEquals("Software Architect",userTemplate.apply(user));
}
