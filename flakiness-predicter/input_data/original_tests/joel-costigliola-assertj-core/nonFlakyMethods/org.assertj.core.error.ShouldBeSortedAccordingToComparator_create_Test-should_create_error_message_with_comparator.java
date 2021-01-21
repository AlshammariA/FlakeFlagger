@Test public void should_create_error_message_with_comparator(){
  ErrorMessageFactory factory=shouldBeSortedAccordingToGivenComparator(1,array("b","c","A"),new CaseInsensitiveStringComparator());
  String message=factory.create(new TestDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \ngroup is not sorted according to 'CaseInsensitiveStringComparator' comparator because element 1:\n <\"c\">\nis not less or equal than element 2:\n <\"A\">\ngroup was:\n <[\"b\", \"c\", \"A\"]>",message);
}
