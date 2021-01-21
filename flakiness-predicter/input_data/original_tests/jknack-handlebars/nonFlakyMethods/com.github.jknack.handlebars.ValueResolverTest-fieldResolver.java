@Test public void fieldResolver(){
  Context context=Context.newBuilder(new Base("a","b")).resolver(FieldValueResolver.INSTANCE).build();
  assertNotNull(context);
  assertEquals("a",context.get("base"));
  assertEquals("b",context.get("child"));
}
