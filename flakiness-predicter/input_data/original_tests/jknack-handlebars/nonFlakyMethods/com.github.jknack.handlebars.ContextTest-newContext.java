@Test public void newContext(){
  Context context=Context.newContext("String");
  assertNotNull(context);
  assertEquals("String",context.model());
}
