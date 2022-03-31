# Trove QA Automation Engineer Challenge

This repository is meant to provide Trove SQA Automation Engineeer interview candidates with a takehome interview challenge starting point. It includes:

- A fullstack [Next.js](https://nextjs.org/) application.
- A SQLite database and [Prisma](https://www.prisma.io/) client.
- A minimal [Cypress](https://www.cypress.io/) UI test automation harness.
- A minimal [Jest](https://jestjs.io/) and [SuperAgent](https://visionmedia.github.io/superagent/) API test automation harness.

## Dependencies

- Node (tested on Node 16.5.0).
- SQLite (tested on SQLite 3.32.3).

## Setup

- Install Node dependencies:

```sh
npm install
```

- Seed/reset the database:

```sh
npm run db:reset
```

## Execution

Start the webserver on [`localhost:3000`](http://localhost:3000/):

```sh
npm run dev
```

## Testing

### API Integration Tests

With the webserver running (see [Execution](#execution) above), run:

```sh
npm test
```

### End-to-End UI Tests

With the webserver running (see [Execution](#execution) above), run Cypress:

```sh
npm run cypress
```

To execute Cypress in its [graphical test runner](https://docs.cypress.io/guides/core-concepts/test-runner) instead, run:

```sh
npm run cypress:open
```

## Challenge

Improve this repository's end-to-end UI and/or API integration test coverage by implementing additional test cases.

The fullstack [Next.js](https://nextjs.org/) application under test has a number of bugs and user experience problems. Please provide us with reports of any bugs or enhancements you identify when submitting your challenge.

You will need to explore the application under test and this codebase in order to design and implement your new test cases. You will find the application's pages and API routes under [`pages/`](pages/).

### Requirements

Select one of the approaches below.

#### First Approach

If you have experience with/interest in both API and UI testing:

- Implement at least one new end-to-end test case under `cypress/integration` using [Cypress](https://www.cypress.io/). Refer to [`cypress/integration/signup.spec.js`](cypress/integration/signup.spec.js) for an example.
- Implement at least one new API integration test case under `__tests__` using [Jest](https://jestjs.io/) and [SuperAgent](https://visionmedia.github.io/superagent/). Refer to [`__tests__/user.test.js`](__tests__/user.test.js) for an example.

#### Second Approach

If your focus is primarily in web automation:

- Implement at least two new end-to-end test cases under `cypress/integration` using [Cypress](https://www.cypress.io/). Refer to [`cypress/integration/signup.spec.js`](cypress/integration/signup.spec.js) for an example.

#### Third Approach

If your focus is primarily in API automation:

- Implement at least two new API integration test cases under `__tests__` using [Jest](https://jestjs.io/) and [SuperAgent](https://visionmedia.github.io/superagent/). Refer to [`__tests__/user.test.js`](__tests__/user.test.js) for an example.

### Alternative Solutions

If you'd prefer to use different tools or programming languages to implement your tests than those selected here, feel free to do so. The requirements are the same (1+ UI and 1+ API, 2+ UI, or 2+ API test cases), but you will need to implement whatever dependency management, build tooling, and/or documentation is necessary to execute the tests you end up automating.
