@Test public void mapResolver(){
  Map<String,Object> map=new HashMap<String,Object>();
  map.put("base","a");
  map.put("child","b");
  Context context=Context.newBuilder(map).resolver(MapValueResolver.INSTANCE).build();
  assertNotNull(context);
  assertEquals("a",context.get("base"));
  assertEquals("b",context.get("child"));
}
