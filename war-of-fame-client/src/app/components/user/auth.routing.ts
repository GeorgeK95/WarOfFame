import {SignUpComponent} from './signUp/sign-up.component';
import {SignInComponent} from './signIn/sign-in.component';
import {ProfileComponent} from './profile/profile.component';

const SIGN_UP = 'signup';
const SIGN_IN = 'signin';
const PROFILE = ':username';

export const authRoutes = [
  {path: SIGN_UP, component: SignUpComponent},
  {path: SIGN_IN, component: SignInComponent},
  {path: PROFILE, component: ProfileComponent}
];
