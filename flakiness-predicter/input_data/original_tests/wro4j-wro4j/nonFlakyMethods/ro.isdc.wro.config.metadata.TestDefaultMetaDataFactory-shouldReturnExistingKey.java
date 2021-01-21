@Test public void shouldReturnExistingKey(){
  final Map<String,Object> map=new HashMap<String,Object>();
  map.put("key","value");
  victim=new DefaultMetaDataFactory(map);
  assertEquals(map,victim.create());
  assertEquals("value",victim.create().get("key"));
}
