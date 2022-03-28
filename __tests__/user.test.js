const { PrismaClient } = require("@prisma/client");
const superagent = require("superagent");

const prisma = new PrismaClient();
const user = { name: "Example User", email: "example@example.com" };

describe("/api/user", () => {
  afterEach(async () => {
    await prisma.user.delete({ where: { email: user.email } });
  });

  it("creates a new user", async () => {
    const request = await superagent
      .post("http://localhost:3000/api/user")
      .send(user);
    const dbUser = await prisma.user.findFirst({
      where: { email: user.email },
    });

    expect(request.ok).toEqual(true);
    expect(request.status).toEqual(200);
    expect(request.body).toMatchObject(user);
    expect(dbUser).not.toBeNull();

    ["email", "id", "name"].forEach((property) => {
      expect(request.body).toHaveProperty(property);
      expect(dbUser).toHaveProperty(property);
      expect(dbUser[property]).toEqual(request.body[property]);
    });
  });
});
