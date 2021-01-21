@Test public void greaterThanPredicate(){
  List<ValuePathTuple> data=ImmutableList.of(new ValuePathTuple("a","foobar"),new ValuePathTuple("b","foobar"),new ValuePathTuple("c","foobar"),new ValuePathTuple("d","foobar"),new ValuePathTuple("e","foobar"),new ValuePathTuple("f","foobar"));
  Iterator<ValuePathTuple> filtered=Iterables.filter(data,new ValuePathTuple.GreaterThanPredicate("b")).iterator();
  assertTrue(filtered.hasNext());
  assertEquals("c",filtered.next().getValue());
  assertEquals("d",filtered.next().getValue());
  assertEquals("e",filtered.next().getValue());
  assertEquals("f",filtered.next().getValue());
  assertFalse(filtered.hasNext());
}
