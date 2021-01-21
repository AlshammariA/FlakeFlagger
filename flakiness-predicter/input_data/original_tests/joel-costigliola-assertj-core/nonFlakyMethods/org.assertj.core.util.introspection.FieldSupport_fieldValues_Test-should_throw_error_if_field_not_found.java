@Test public void should_throw_error_if_field_not_found(){
  thrown.expect(IntrospectionError.class,"Unable to obtain the value of the field <'id.'> from <Employee[id=1, name=Name[first='Yoda', last='null'], age=800]>");
  fieldSupport.fieldValues("id.",Long.class,employees);
}
