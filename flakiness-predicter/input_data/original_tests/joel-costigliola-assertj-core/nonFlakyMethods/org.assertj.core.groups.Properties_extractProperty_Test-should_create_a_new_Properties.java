@Test public void should_create_a_new_Properties(){
  Properties<Object> properties=Properties.extractProperty("id",Object.class);
  assertThat(properties.propertyName).isEqualTo("id");
}
