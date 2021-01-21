@Test public void shouldCreateContextWithNullArguments(){
  final WildcardContext context=new WildcardContext(null,null);
  assertNull(context.getUri());
  assertNull(context.getFolder());
  assertNull(context.getWildcard());
}
