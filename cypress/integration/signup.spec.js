const user = { name: "New User", email: "new-user@example.com" };

describe("/signup", () => {
  beforeEach(() => {
    cy.intercept("POST", "/api/user").as("postUser");
    cy.visit("/signup");
  });

  afterEach(() => {
    cy.task("db", {
      operation: "user.delete",
      variables: { where: { email: user.email } },
    });
  });

  it("signs up a new user", () => {
    cy.get('[placeholder="Name"]').type(user.name);
    cy.get('[placeholder="Email address"]').type(user.email);
    cy.get('[type="submit"]').should("be.enabled").click();

    cy.wait("@postUser")
      .its("response.body")
      .then((responseBody) => {
        expect(responseBody).to.have.property("name", user.name);
        expect(responseBody).to.have.property("email", user.email);
        expect(responseBody).to.have.property("id");
        expect(typeof responseBody.id).to.eq("number");
      });

    cy.url().should("not.have.string", "/signup");
    cy.location().its("pathname").should("eq", "/");
  });
});
