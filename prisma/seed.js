const { PrismaClient } = require("@prisma/client");

const prisma = new PrismaClient();

const userData = [
  {
    name: "Alice",
    email: "alice@example.com",
    posts: {
      create: [
        {
          title: "Alice Coming in Hot",
          content: "First!",
          published: true,
        },
      ],
    },
  },
  {
    name: "Bob",
    email: "bob@example.com",
    posts: {
      create: [
        {
          title: "Bob Here",
          content: "Sup.",
          published: true,
          viewCount: 42,
        },
      ],
    },
  },
  {
    name: "Kae",
    email: "kae@example.com",
    posts: {
      create: [
        {
          title: "Kae's First Post!",
          content: "Love this.",
          published: true,
          viewCount: 128,
        },
        {
          title: "WIP Post",
          content: "Still thinking on this one...",
        },
      ],
    },
  },
];

async function main() {
  console.log(`Start seeding ...`);
  for (const u of userData) {
    const user = await prisma.user.create({
      data: u,
    });
    console.log(`Created user with id: ${user.id}`);
  }
  console.log(`Seeding finished.`);
}

main()
  .catch((e) => {
    console.error(e);
    process.exit(1);
  })
  .finally(async () => {
    await prisma.$disconnect();
  });
