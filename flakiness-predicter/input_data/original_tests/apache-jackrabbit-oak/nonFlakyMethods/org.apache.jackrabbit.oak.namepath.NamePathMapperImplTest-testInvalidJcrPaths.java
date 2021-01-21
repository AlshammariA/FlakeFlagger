@Test public void testInvalidJcrPaths(){
  String[] paths={"//","/foo//","/..//","/..","/foo/../..","foo::bar","foo:bar:baz","foo:bar]baz","foo:bar[baz","foo:bar|baz","foo:bar*baz"};
  NamePathMapper[] mappers={npMapper,new NamePathMapperImpl(new LocalNameMapper(GLOBAL,Collections.<String,String>emptyMap()))};
  for (  NamePathMapper mapper : mappers) {
    for (    String path : paths) {
      assertNull(path,mapper.getOakPath(path));
    }
  }
}
