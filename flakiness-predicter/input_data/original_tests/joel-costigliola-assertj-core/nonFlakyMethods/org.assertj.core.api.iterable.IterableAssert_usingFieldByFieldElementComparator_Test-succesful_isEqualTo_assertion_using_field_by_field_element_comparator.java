@Test public void succesful_isEqualTo_assertion_using_field_by_field_element_comparator(){
  List<Foo> list1=singletonList(new Foo("id",1));
  List<Foo> list2=singletonList(new Foo("id",1));
  assertThat(list1).usingFieldByFieldElementComparator().isEqualTo(list2);
}
