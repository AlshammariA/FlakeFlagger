@Test public void should_create_Assert_generics(){
  Employee bill=new Employee("bill");
  Person billou=bill;
  Assertions.assertThat(bill).isEqualTo(billou);
  Assertions.assertThat(billou).isEqualTo(bill);
}
