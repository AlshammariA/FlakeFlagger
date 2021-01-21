@Test public void combine(){
  Context context=Context.newBuilder(new Base()).combine("expanded","value").build();
  assertNotNull(context);
  assertEquals("baseProperty",context.get("baseProperty"));
  assertEquals("value",context.get("expanded"));
}
