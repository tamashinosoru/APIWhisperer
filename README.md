**>>> API Whisperer <<<**

API Whisperer is a friendly tool that reads how an API works and turns that into easy to understand notes and ready to use examples. It is meant to save time for people who need to use an API but do not want to read long technical documents. The tool can read common API files or a plain endpoint address and will give clear summaries, example calls you can paste into your code, and a little interactive tester so you can try requests without setting up a lot of stuff.

What It Does:

Accepts an API spec file or a single endpoint address from the user
Summarizes each endpoint in plain English so you know what it does and when to use it
Shows the inputs the endpoint needs and what kind of reply to expect
Produces copy paste ready examples in JavaScript and Python
Lets you try an endpoint from a small web interface and see the real response

What I Learned:

I learned how API descriptions are usually written so I can turn them into plain language. This involved reading OpenAPI and Postman formats which are basically recipes for how an API works
I practiced working with JSON which is the common data format APIs use so I could extract useful fields and examples
I got comfortable talking to other services securely using API keys which meant learning how to store and load secrets safely
I built a small web interface and learned how to send and receive requests from it so users can try endpoints in the browser
I learned to use a language model to rewrite technical text into easy words and to generate example code that actually runs

How to Run:

Clone the repository by entering this into your terminal
git clone https colon slash slash github dot com slash yourusername slash apiwhisperer.git

Install the frontend and backend dependencies
cd apiwhisperer
npm install
or if you are using Python for the backend
pip install -r requirements dot txt

Start the app locally
npm run dev

When prompted in the web interface, paste an API spec url or upload a spec file for example
https colon slash slash api dot example dot com slash openapi dot json

Desired Sample API Format:

GET https colon slash slash api dot example dot com slash users
Request query parameters optional page and limit
Response example
[
{
id 1
name "Aisha"
email "aisha@example.com
"
}
]

Development Notes

During development I had to learn how to parse different spec file layouts and normalize them into one simple internal view
I spent time learning how to turn a formal parameter list into a short plain sentence that a non technical person can understand
I built small example generators for JavaScript and Python by studying common request patterns and testing them against real endpoints
I tested with Postman and with simple curl like requests to make sure examples matched actual API behavior
I focused on making the UI simple so someone who has never used an API can copy an example and get a working response quickly

Thank you for reading If you want I can make a short one page version for a portfolio or expand the developer instructions with exact file names and configs
