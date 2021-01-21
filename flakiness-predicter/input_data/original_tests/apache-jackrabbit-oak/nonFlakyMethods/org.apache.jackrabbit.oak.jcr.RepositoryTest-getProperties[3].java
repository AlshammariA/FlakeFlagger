@Test public void getProperties() throws RepositoryException {
  Set<String> propertyNames=new HashSet<String>(){
{
      add("intProp");
      add("mvProp");
      add("added");
    }
  }
;
  Set<String> values=new HashSet<String>(){
{
      add("added");
      add("1");
      add("2");
      add("3");
      add("42");
    }
  }
;
  Node node=getNode("/foo");
  node.setProperty("added","added");
  node.getProperty("stringProp").remove();
  node.getProperty("intProp").remove();
  node.setProperty("intProp",42);
  PropertyIterator properties=node.getProperties();
  assertEquals(4,properties.getSize());
  while (properties.hasNext()) {
    Property p=properties.nextProperty();
    if (JcrConstants.JCR_PRIMARYTYPE.equals(p.getName())) {
      continue;
    }
    assertTrue(propertyNames.remove(p.getName()));
    if (p.isMultiple()) {
      for (      Value v : p.getValues()) {
        assertTrue(values.remove(v.getString()));
      }
    }
 else {
      assertTrue(values.remove(p.getString()));
    }
  }
  assertTrue(propertyNames.isEmpty());
  assertTrue(values.isEmpty());
}
