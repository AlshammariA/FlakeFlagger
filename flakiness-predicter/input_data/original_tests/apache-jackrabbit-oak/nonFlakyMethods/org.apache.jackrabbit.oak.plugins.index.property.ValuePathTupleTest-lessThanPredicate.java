@Test public void lessThanPredicate(){
  List<ValuePathTuple> data=ImmutableList.of(new ValuePathTuple("a","foobar"),new ValuePathTuple("b","foobar"),new ValuePathTuple("c","foobar"),new ValuePathTuple("d","foobar"),new ValuePathTuple("e","foobar"),new ValuePathTuple("f","foobar"));
  Iterator<ValuePathTuple> filtered=Iterables.filter(data,new ValuePathTuple.LessThanPredicate("e")).iterator();
  assertTrue(filtered.hasNext());
  assertEquals("a",filtered.next().getValue());
  assertEquals("b",filtered.next().getValue());
  assertEquals("c",filtered.next().getValue());
  assertEquals("d",filtered.next().getValue());
  assertFalse(filtered.hasNext());
  data=ImmutableList.of(new ValuePathTuple("f","foobar"),new ValuePathTuple("e","foobar"),new ValuePathTuple("d","foobar"),new ValuePathTuple("c","foobar"),new ValuePathTuple("b","foobar"),new ValuePathTuple("a","foobar"));
  filtered=Iterables.filter(data,new ValuePathTuple.LessThanPredicate("e")).iterator();
  assertTrue(filtered.hasNext());
  assertEquals("d",filtered.next().getValue());
  assertEquals("c",filtered.next().getValue());
  assertEquals("b",filtered.next().getValue());
  assertEquals("a",filtered.next().getValue());
  assertFalse(filtered.hasNext());
}
