import {SignUpComponent} from './signUp/sign-up.component';
import {SignInComponent} from './signIn/sign-in.component';

const SIGN_UP = 'signup';
const SIGN_IN = 'signin';

export const authRoutes = [
  {path: SIGN_UP, component: SignUpComponent},
  {path: SIGN_IN, component: SignInComponent}
];
