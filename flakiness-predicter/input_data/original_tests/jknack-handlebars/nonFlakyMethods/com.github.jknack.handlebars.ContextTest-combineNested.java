@Test public void combineNested(){
  Map<String,Object> expanded=new HashMap<String,Object>();
  expanded.put("a","a");
  expanded.put("b",true);
  Context context=Context.newBuilder(new Base()).combine("expanded",expanded).build();
  assertNotNull(context);
  assertEquals("baseProperty",context.get("baseProperty"));
  assertEquals(expanded,context.get("expanded"));
  assertEquals("a",context.get("expanded.a"));
  assertEquals(true,context.get("expanded.b"));
}
