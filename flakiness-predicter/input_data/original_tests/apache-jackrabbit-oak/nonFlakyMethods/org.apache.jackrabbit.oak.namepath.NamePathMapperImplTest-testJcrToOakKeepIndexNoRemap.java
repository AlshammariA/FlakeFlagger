@Test public void testJcrToOakKeepIndexNoRemap(){
  NameMapper mapper=new GlobalNameMapper(GLOBAL);
  NamePathMapper npMapper=new NamePathMapperImpl(mapper);
  assertEquals("/",npMapper.getOakPathKeepIndex("/"));
  assertEquals("/foo:bar",npMapper.getOakPathKeepIndex("/foo:bar"));
  assertEquals("/foo:bar/quu:qux",npMapper.getOakPathKeepIndex("/foo:bar/quu:qux"));
  assertEquals("foo:bar",npMapper.getOakPathKeepIndex("foo:bar"));
}
