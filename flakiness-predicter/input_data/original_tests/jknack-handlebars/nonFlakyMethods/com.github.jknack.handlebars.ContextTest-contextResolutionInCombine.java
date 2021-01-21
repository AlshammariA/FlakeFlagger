@Test public void contextResolutionInCombine(){
  Context context=Context.newBuilder(new Base()).combine("baseProperty","value").build();
  assertNotNull(context);
  assertEquals("baseProperty",context.get("baseProperty"));
}
