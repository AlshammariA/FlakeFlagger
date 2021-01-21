@Test public void should_create_comparator_using_fields(){
  OnFieldsComparator comparator=new OnFieldsComparator("a","b");
  assertThat(comparator).isNotNull();
  assertThat(comparator.getFields()).containsExactly("a","b");
}
