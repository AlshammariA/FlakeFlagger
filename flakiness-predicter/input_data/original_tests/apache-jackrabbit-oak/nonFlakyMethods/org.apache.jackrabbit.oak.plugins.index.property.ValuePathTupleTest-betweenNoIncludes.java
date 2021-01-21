@Test public void betweenNoIncludes(){
  List<ValuePathTuple> data=ImmutableList.of(new ValuePathTuple("a","foobar"),new ValuePathTuple("b","foobar"),new ValuePathTuple("c","foobar"),new ValuePathTuple("d","foobar"),new ValuePathTuple("e","foobar"),new ValuePathTuple("f","foobar"));
  Iterator<ValuePathTuple> filtered=Iterables.filter(data,new ValuePathTuple.BetweenPredicate("b","d",false,false)).iterator();
  assertTrue(filtered.hasNext());
  assertEquals("c",filtered.next().getValue());
  assertFalse(filtered.hasNext());
}
