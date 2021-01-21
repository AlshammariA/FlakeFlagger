@Test public void expanded(){
  Map<String,Object> expanded=new HashMap<String,Object>();
  expanded.put("a","a");
  expanded.put("b",true);
  Context context=Context.newBuilder(new Base()).combine(expanded).build();
  assertNotNull(context);
  assertEquals("baseProperty",context.get("baseProperty"));
  assertEquals(null,context.get("expanded"));
  assertEquals("a",context.get("a"));
  assertEquals(true,context.get("b"));
}
