@Test public void testVerticalLineInName() throws Exception {
  List<String> names=ImmutableList.of("jcr:con|ent","jcr:|ontent","jcr:conten|","con|ent","|ontent","conten|");
  testNames(names);
}
