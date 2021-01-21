@Test public void should_create_AssertionError_with_message_differentiating_expected_and_actual_persons_even_if_a_comparator_based_comparison_strategy_is_used(){
  Person actual=new Person("Jake",43);
  Person expected=new Person("Jake",47);
  ComparisonStrategy ageComparisonStrategy=new ComparatorBasedComparisonStrategy(new PersonComparator());
  shouldBeEqual=(ShouldBeEqual)shouldBeEqual(actual,expected,ageComparisonStrategy,new StandardRepresentation());
  shouldBeEqual.descriptionFormatter=mock(DescriptionFormatter.class);
  when(shouldBeEqual.descriptionFormatter.format(description)).thenReturn(formattedDescription);
  AssertionError error=shouldBeEqual.newAssertionError(description,new StandardRepresentation());
  assertThat(error.getMessage()).isEqualTo("[my test] \n" + "Expecting:\n" + " <\"Person[name=Jake] (Person@" + toHexString(actual.hashCode()) + ")\">\n"+ "to be equal to:\n <\"Person[name=Jake] (Person@"+ toHexString(expected.hashCode())+ ")\">\n"+ "when comparing values using 'PersonComparator' but was not.");
}
