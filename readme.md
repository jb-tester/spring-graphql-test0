# Spring GraphQL support test

~~**233.9102 state:**~~ - FIXED

~~1. install GraphQL plugin:~~
 ~~- endpoints are detected from schema~~
 ~~- no other support~~
 ~~- HTTP Client is broken (see `graphql.http`)~~

~~2. install Spring GraphQL: everything is broken~~

- Incorrect GraphQL requests generating for mappings:
  - add the "/graphql" path to request automatically
  - redundant `()` after query name for parameter-less methods
  - in case of parameters: query itself uses var as parameter
  - nothing is generated in the Endpoints view
  

- mapping annotations:
  - rename doesn't work correctly for explicit #value/#field value in @SchemaMapping (and derived annotations)
  - no navigation from mappings to Endpoints