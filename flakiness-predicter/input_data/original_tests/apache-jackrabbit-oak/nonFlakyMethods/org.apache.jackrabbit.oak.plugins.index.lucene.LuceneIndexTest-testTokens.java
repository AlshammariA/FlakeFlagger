@Test public void testTokens(){
  assertEquals(ImmutableList.of("parent","child"),LuceneIndex.tokenize("/parent/child",analyzer));
  assertEquals(ImmutableList.of("p1234","p5678"),LuceneIndex.tokenize("/p1234/p5678",analyzer));
  assertEquals(ImmutableList.of("first","second"),LuceneIndex.tokenize("first_second",analyzer));
  assertEquals(ImmutableList.of("first1","second2"),LuceneIndex.tokenize("first1_second2",analyzer));
  assertEquals(ImmutableList.of("first","second"),LuceneIndex.tokenize("first. second",analyzer));
  assertEquals(ImmutableList.of("first","second"),LuceneIndex.tokenize("first.second",analyzer));
  assertEquals(ImmutableList.of("hello","world"),LuceneIndex.tokenize("hello-world",analyzer));
  assertEquals(ImmutableList.of("hello","wor*"),LuceneIndex.tokenize("hello-wor*",analyzer));
  assertEquals(ImmutableList.of("*llo","world"),LuceneIndex.tokenize("*llo-world",analyzer));
  assertEquals(ImmutableList.of("*llo","wor*"),LuceneIndex.tokenize("*llo-wor*",analyzer));
}
